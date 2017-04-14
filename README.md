# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Project #2: Mobile Commerce App

#### Overview

The app created for this project is an e-commerce simulator. Users can browse and search for items, view full details for the items, and add them to the cart. In the cart, users can increment and decrement the quantity of each item, remove items, and check out.

---

#### Functionality

The app opens to an empty list of to-do lists with a `FloatingActionButton`. Clicking the button brings up an `AlertDialog` with an `EditText` asking for a title for a new list. The **Done** button cannot be successfully clicked until a value is entered into the `EditText`. If no value is entered, an error is displayed and the text field takes focus. Once a valid value is entered a new list is created and the to-do list activity is launched. If a to-do list is long clicked in the main activity, a dialog is displayed asking the user to confirm removing the list. Each list item on this screen also displays the number of items in the to-do list.

The to-do list activity displays the list name at the top of the screen. A new to-do list is initially empty. Clicking the `FloatingActionButton` opens an `AlertDialog` with two `EditText` fields, one for a new item title and one for a new item description. The new title is required, while the description is optional. Entering just a title creates a new to-do item that features a `CheckBox` with one `TextView`, while entering both a title and description creates a new to-do item with a `CheckBox` and two `TextView`s, one for the title, and one for the description. For any to-do item, clicking the `CheckBox` will check the box and fade the text, while unchecking it will re-darken the text. Clicking an existing to-do item brings up an edit window in which the user can update the title and/or description, based on the type of item it is. Long clicking the item brings up an alert asking the user to confirm the deletion of the item.

---

#### Known Bugs

- None known!

---

#### Screenshots

<p align="center">
  <img src="screenshots/singlePane_main.jpg” > 
  <img src="screenshots/singlePane_detail.jpg” width=“250px" >
  <img src="screenshots/singlePane_cart.jpg” width=“250px" >
  <img src="screenshots/singlePane_checkout_full.jpg” width=“250px" >
  <img src="screenshots/singlePane_checkout_empty.jpg” width=“250px" >
  <img src="screenshots/dualPane_main.jpg” width=“250px" >
  <img src="screenshots/dualPane_detail.jpg” width=“250px" >
  <img src="screenshots/dualPane_cart.jpg” width=“250px" />
  <img src="screenshots/dualPane_checkout.jpg” width=“250px" >
</p>
