# JM's Pharmacy An Inventory System 🚑💊
A lightweight Java console application for small pharmacies. Two roles: USER (customer) and ADMIN (inventory manager). Stores data in simple files, so it runs anywhere with a JDK.

## Key Features ✨
- Implements Basic Operations: Create, Read, Update, Delete
- User accounts: login, view products
- Admin inventory: add / edit / delete products, manage batches
- Batch tracking: batch number, expiry date, per-batch quantity
- Simple import/export: JSON import/export for products and inventory

## Run Locally (compile & run) ▶️
Requirements: Java 11+ (JDK). No Maven/Gradle required.

## Console Commands / User Flows 🧭
- Startup menu:
  - [1] User Login
  - [2] Admin Login
  - [3] Exit
- After login (USER):
  - [1] Buy Medicine
  - [2] View account details
  - [3] Deposit funds
  - [4] View transaction history
  - [5] Logout 
- After login (ADMIN):
  - [1] Add product
  - [2] Edit product
  - [3] Receive batch
  - [4] Adjust stock
  - [5] View low-stock
  - [6] View audit log
  - [7] Manage users
  - [8] Logout
