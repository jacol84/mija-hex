package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState
import spock.lang.Specification

class SpockTest extends Specification {

    def "check mapper order to orderDto"() {
        given:
        def order = new Order(id, disName, OrderState.NEW)
        when:
        def orderDto = new OrderFactory().toOrderDto(order)
        then:
        assert expectedId == orderDto.getOrderId()
        assert expectedName == orderDto.getDisName()
        where:
        id | disName     || expectedId | expectedName
        10 | "Hod dog"   || 10         | "Hod dog"
        10 | "Hamburger" || 10         | "Hamburger"
    }


}
