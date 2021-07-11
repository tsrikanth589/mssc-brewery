package guru.springframework.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.dto.BeerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID id) {
		
		return BeerDto.builder()
						.id(id)
						.beerName("Knock out")
						.beerStyle("Light")
						.build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		
		return BeerDto.builder()
						.id(UUID.randomUUID())
						.beerName(beerDto.getBeerName())
						.beerStyle(beerDto.getBeerStyle())
						.upc(beerDto.getUpc())
						.build();
	}

	@Override
	public void updateBeer(UUID id, BeerDto beerDto) {
		// Need to add logic
		
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		
		log.debug("Deleting the beer :" + beerId);
	}
	
	

}
