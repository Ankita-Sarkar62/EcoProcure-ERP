# EcoProcure - Enterprise Procurement Management System

## Overview

EcoProcure is an enterprise procurement management system developed to manage the process of employee purchase requests, managerial approval, vendor selection, inventory management, and procurement tracking.

The system provides different access and workflows for employees and managers. It also includes a vendor recommendation mechanism that considers factors such as price, sustainability, reliability, delivery time, and transportation distance.

## Main Features

### Employee

- Employee login and authentication
- Employee dashboard
- Create and view purchase requests
- View vendor recommendations
- View products and vendors
- Track purchase request status

### Manager

- Manager login and authentication
- Manager dashboard
- View and manage purchase requests
- Approve or reject purchase requests
- Assign vendors
- Manage products and vendors
- Manage inventory
- View employee information

### Vendor Recommendation

The system provides vendor recommendations based on multiple procurement factors:

- Price
- Sustainability
- Reliability
- Delivery time
- Transportation distance

### Role-Based Access

Different application features are available depending on the logged-in user's role.

Employees can create and track their own purchase requests, while managers have access to approval, vendor assignment, inventory, employee management, and other administrative functions.

The application also restricts unauthorized access to manager-specific routes.

## Project Structure

```text
EcoProcure-ERP/
│
├── ecoprocure/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── database/
│   └── ecoprocure_schema.sql
│
└── README.md