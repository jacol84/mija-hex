package mija.hex.domain.restaurant.infrastructure.spring

import mija.hex.domain.restaurant.RestaurantFacade
import mija.hex.domain.restaurant.port.primary.CookCommandService
import org.springframework.stereotype.Service

@Service
class CookCommandAppService(val restaurantFacade: RestaurantFacade) : CookCommandService by restaurantFacade.cookCommandService