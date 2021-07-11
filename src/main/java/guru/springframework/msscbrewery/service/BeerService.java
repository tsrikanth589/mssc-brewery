package guru.springframework.msscbrewery.service;

import java.util.UUID;

import guru.springframework.msscbrewery.dto.BeerDto;

public interface BeerService {
	
	BeerDto getBeerById(UUID id);
	
	BeerDto saveNewBeer(BeerDto beerDto);
	
	void updateBeer(UUID id, BeerDto beerDto);

	void deleteBeerById(UUID beerId);
}
