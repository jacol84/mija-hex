package mija.hex.infrastructure.app.restaurant.adapter.primary

import mija.hex.domain.restaurant.RestaurantFacade
import mija.hex.domain.restaurant.port.primary.CookCommandService
import org.springframework.stereotype.Service

@Service
internal class CookCommandAppService(val restaurantFacade: RestaurantFacade) : CookCommandService by restaurantFacade.cookCommandService