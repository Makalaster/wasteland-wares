# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project #2: Mobile Commerce App

#### Overview

The app created for this project is an e-commerce simulator. Users can browse and search for items, view full details for the items, and add them to the cart. In the cart, users can increment and decrement the quantity of each item, remove items, and check out.

---

#### Functionality

The app opens to a screen containing a list of items for sale. Along the top of the list are tabs with the different categories of items available. Swiping through each page filters the list of items based on their category. Above the tabs is a magnifying glass icon that when pressed opens a `SearchView`. Typing search terms into this pane and pressing enter will search through the database of items available and display them on the screen. If the user is in a tab other than the ALL tab, only results relevant to that tab will be shown. Closing the search view restores the default filtered results of the current tab.

If a user taps on an item, the detail view is opened. This page contains relevant details for the selected item. Each category of item has a slightly different set of relevant attributes. This page also contains a `FloatingActionButton` that will add the current item to the cart. When this is done a `SnackBar` appears at the bottom of the screen confirming that the item has been added.

On the main screen of the app, there is a `FloatingActionButton` that opens the cart. The cart displays a list of all items that have been added in a `RecyclerView`


The app opens to an empty list of to-do lists with a `FloatingActionButton`. Clicking the button brings up an `AlertDialog` with an `EditText` asking for a title for a new list. The **Done** button cannot be successfully clicked until a value is entered into the `EditText`. If no value is entered, an error is displayed and the text field takes focus. Once a valid value is entered a new list is created and the to-do list activity is launched. If a to-do list is long clicked in the main activity, a dialog is displayed asking the user to confirm removing the list. Each list item on this screen also displays the number of items in the to-do list.

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
