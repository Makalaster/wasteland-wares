# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project #2: Mobile Commerce App

#### Overview

The app created for this project is an e-commerce simulator. Users can browse and search for items, view full details for the items, and add them to the cart. In the cart, users can increment and decrement the quantity of each item, remove items, and check out.

---

#### Functionality

The app opens to a screen containing a list of items for sale. Along the top of the list are tabs with the different categories of items available. Swiping through each page filters the list of items based on their category. Above the tabs is a magnifying glass icon that when pressed opens a `SearchView`. Typing search terms into this pane and pressing enter will search through the database of items available and display them on the screen. If the user is in a tab other than the ALL tab, only results relevant to that tab will be shown. Closing the search view restores the default filtered results of the current tab.

If a user taps on an item, the detail view is opened. This page contains relevant details for the selected item. Each category of item has a slightly different set of relevant attributes. This page also contains a `FloatingActionButton` that will add the current item to the cart. When this is done a `SnackBar` appears at the bottom of the screen confirming that the item has been added. If this item is already present in the cart, tapping the add button will increase the number of that item in the cart.

On the main screen of the app, there is a `FloatingActionButton` that opens the cart. The cart displays a list of all items that have been added in a `RecyclerView`. Each item in the cart has a picture, the name, the total price, the current quantity, an add button and a remove button. Tapping the add button increases the number of that item in the cart and adjusts the total price for that item accordingly. Tapping the remove button will decrease the number of that item in the cart, and adjust the total price accordingly. If there is only one of an item in the cart when the remove button is pressed, the item is removed from the cart.

When a user taps the checkout button in the cart, a check is performed for whether there are currently any items in the cart. If there are no items, a popup message is displayed asking the user to first add items. If there are items in the cart, a confirmation dialog is displayed with the total price. Confirming checkout brings up a `SnackBar` thanking the user for their patronage. At this time, all items are removed from the cart.

If this app is run on a screen that is wider than 900dp, it is displayed in a two-pane mode. On the left is the list of available items, and on the right is a space that is occupied by either the cart, or the detail view of an item, whichever was selected most recently.

---

#### Known Bugs

- None known!

---

#### Screenshots

<p align="center">
  <img src="screenshots/singlePane_main.jpg” width=“250”/> 
  <img src="screenshots/singlePane_detail.jpg” width=“250“/>
  <img src="screenshots/singlePane_cart.jpg” width=“250”/>
  <img src="screenshots/singlePane_checkout_full.jpg” width=“250”/>
  <img src="screenshots/singlePane_checkout_empty.jpg” width=“250”/>
  <img src="screenshots/dualPane_main.jpg” width=“250”/>
  <img src="screenshots/dualPane_detail.jpg” width=“250”/>
  <img src="screenshots/dualPane_cart.jpg” width=“250”/>
  <img src="screenshots/dualPane_checkout.jpg” width=“250”/>
</p>
