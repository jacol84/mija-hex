

rootProject.name = "mija-hex"
include("application")

include("command-bus")

include("food-order-app:food-order-domain")
include("food-order-app:food-order-infrastructure")
include("food-order-app:food-order-api")

include("restaurant-app:restaurant-domain")
include("restaurant-app:restaurant-infrastructure")
include("restaurant-app:restaurant-api")

include("delivery-app:delivery-infrastructure")
include("delivery-app:delivery-domain")
include("delivery-app:delivery-api")

//findProject(":restaurant-app:restaurant-api")?.name = "restaurant-api"
