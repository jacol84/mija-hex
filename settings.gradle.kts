

rootProject.name = "mija-hex"
include("application")

include("command-bus")

include("food-order-app:food-order-domain")
include("food-order-app:food-order-infrastructure")
include("food-order-app:food-order-api")
include("food-order-app:food-order-docker")

include("restaurant-app:restaurant-domain")
include("restaurant-app:restaurant-infrastructure")
include("restaurant-app:restaurant-api")
include("restaurant-app:restaurant-docker")

include("delivery-app:delivery-infrastructure")
include("delivery-app:delivery-domain")
include("delivery-app:delivery-api")
include("delivery-app:delivery-docker")
