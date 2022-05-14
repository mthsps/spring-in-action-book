<img img align="right" src="https://user-images.githubusercontent.com/78484194/168450047-f482ea4f-c7f5-454a-b34d-da1a576258ad.png" />

# Spring in Action

An introduction to Spring by developing a Taco store application, where you can login, design a taco and submit an order. 

# What I Have Learned? 

It was my second book on Spring and I was particularly interested in security, as it was something I didn't grasp very well. Even so, I'm always amazed at how we can learn new things by revisiting concepts and seeing different ways to do the same. Also, I found a very solid introduction covering the many aspects of Spring Framework, from Initializr to deploy, going through REST, non-relational databases, messaging, reactive development and more.

Returning to my interest, in Spring, basic security is easy by adding the Spring Boot security starter dependency. After that, the first step is to create SecurityConfig class, which will contain some particular application configuration:

- **PasswordEncoder**: It encodes the password before entering the database and will be used to compare with the typed password encoded by the same  algorithm. 
- **UserDetailsService**:  It allows the creation, storage and access to user’s authentication and authorization information. 
- **Security Filter**:  It controls who has access to certain endpoints.

To complete, the User model implements UserDetails interface, which provides additional information to the model, for example, the authorities and the account status (enabled, active, etc.). 

The presented aspects were used in this application and, of course, can change depending on different needs.


### Reading progress: 
Chapter 08


# Reference

Craig Wall, *Spring in Action, Sixth Edition*. Shelter Island: Manning, 2022.

