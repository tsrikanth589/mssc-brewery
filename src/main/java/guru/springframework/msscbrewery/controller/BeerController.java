package guru.springframework.msscbrewery.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.dto.BeerDto;
import guru.springframework.msscbrewery.service.BeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	private BeerService beerService;

	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@PathVariable UUID beerId) {
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<BeerDto> saveNewBeer(@RequestBody BeerDto beerDto) {
		BeerDto savedDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		
		return new ResponseEntity<BeerDto>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeerById(beerId);
	}
	
	

}
