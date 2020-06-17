

rootProject.name = "mija-hex"
include("application")

include("command-bus")

include("food-order-app:food-order-domain")
include("food-order-app:food-order-infrastructure")
include("food-order-app:food-order-api")

include("restaurant-app:restaurant-domain")
include("restaurant-app:restaurant-infrastructure")

include("delivery-app:delivery-infrastructure")
include("delivery-app:delivery-domain")


//findProject(":delivery-app:delivery-domain")?.name = "delivery-domain"
//findProject(":delivery-app:delivery-infrastructure")?.name = "delivery-infrastructure"
//findProject(":food-order-app:food-order-api")?.name = "food-order-api"
include("delivery-app:delivery-api")
findProject(":delivery-app:delivery-api")?.name = "delivery-api"
include("restaurant-app:restaurant-api")
findProject(":restaurant-app:restaurant-api")?.name = "restaurant-api"
