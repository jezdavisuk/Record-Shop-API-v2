# Record Shop Inventory Management System

### Introduction

The Record Shop Inventory Management System provides a system for tracking, creating, and updating stock items for a fictional retailer TrackDaw, a vendor of records and various other assorted paraphernalia
within the world of music young and old. In its current state, it provides TrackDaw employees a sleek user-friendly interface for querying company stock levels. This repository is a revision on an earlier
iteration with a renewed focus towards making frequent and clean git commits, and a strict adherence to the principles of Test-Driven Development. It also constitutes a radical overhaul of the models to keep 
data consistent (3NF), queries efficient, and data grouped by their classification or functional domain. This last point is paramount; it gives us the flexibility to introduce logic specific to one particular 
data class and its closely-related fields. This not only reduces service layer bloat, but allows us to keep access to sensitive data restricted only to those authorised to do so. 

This is a Spring Boot RESTful API and, in its current form, it handles HTTP requests to perform CRUD operations on a PostgreSQL database instance. It persists data of class Stock, Album, Artist, and Price. 
It follows an MVC (Model-View-Controller) architectural pattern emphasising a modular design with separation of concerns by layer. This confers advantages in ease-of-maintainance and scalability.


### Future Considerations

New types of stock item
