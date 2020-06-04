package mija.hex.domain.order

import mija.hex.domain.order.port.shared.OrderState
import spock.lang.Specification

class SpockTest extends Specification {

    def "check mapper order to orderDto"() {
        given:
        def order = new Order(id, disName, address, OrderState.NEW)
        when:
        def orderDto = new OrderFactory().toOrderDto(order)
        then:
//        assert expectedId == orderDto.getOrderId()
//        assert expectedName == orderDto.getDisName()
        assert expectedAddress == orderDto.getAddress()
        where:
        id | disName     | address  || expectedId | expectedName | expectedAddress
        10 | "Hod dog"   | "desk 1" || 10         | "Hod dog"    | "desk 1"
        10 | "Hamburger" | "desk 1" || 10         | "Hamburger"  | "desk 1"
        10 | "Hamburger" | "ul a"   || 10         | "Hamburger"  | "ul a"
    }


}
