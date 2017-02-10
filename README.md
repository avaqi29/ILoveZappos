# ILoveZappos
This is an Android application for the Zappos Summer intern
It might take time when first launch the app
At MainActivity, it will search for null term and display the items into cards
Search some terms like: nike will results in some item cards and the top left is the first one
Click on the item image will enter the product page with the product details
A floating action button is there for adding item to the cart

The technical nature is to use Retrofit to connect to the Zappos API and get the parsed JSON data to the objects
The product info will be shown onto cardView which follows the Material Design pattern
In the product page, the UI components have been associated by data binding method
Finally the “add to cart” animation is done by drawing the Bezier curve from the image to the cart
