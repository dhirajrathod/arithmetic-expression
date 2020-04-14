# Arithmetic Expression
Programming Test : Arithmetic Expression
 
This is an example of arithmetic expression. There are two ways used for getting it done :
 
* By using Spring SEPL.
* By using Core Java concept in Spring MVC.

Technologies Used :
-------------------
* Use of Java 8
* Used collections, streams, and lambdas expression.
* Spring MVC.
* JSP and JSP tags. (Custom JSP Tags)
* Spring Tags
* Javascript/JQuery, Ajax, JSON
* CSS3 and HTML5
* Spring annotations - @Service, @Repository, @Entity, @Controller
* JPA/Hibernate with h2 DB
* Maven POM
* Database : Hibernate h2 DB2

Usage :
-------------------
* Java 8 :
com\pegasus\arithmetic\expression\commons\EvaluateString.java
com\pegasus\arithmetic\expression\controller\ArithmeticExpressionController.java

* Used collections, streams, and lambdas expression : 
com\pegasus\arithmetic\expression\commons\EvaluateString.java
com\pegasus\arithmetic\expression\controller\ArithmeticExpressionController.java

* Spring annotations - @Service, @Repository, @Entity, @Controller :
com\pegasus\arithmetic\expression\controller\ArithmeticExpressionController.java
com\pegasus\arithmetic\expression\controller\ArithmeticExpressionSEPLController.java
com\pegasus\arithmetic\expression\service\ArithmeticExpressionServiceImpl.java
com\pegasus\arithmetic\expression\dao\ArithmeticExpressionDAOImpl.java
com\pegasus\arithmetic\expression\entity\ArithmeticExpressionDetails.java

* Spring Tags : 
WebContent\WEB-INF\view\arithmetic-expression.jsp
WebContent\WEB-INF\view\arithmetic-expression-sepl.jsp

* JSP and JSP tags. (Custom JSP Tags) : 
com\pegasus\arithmetic\expression\jsptags\CustomJSPTags.java
WebContent\WEB-INF\view\arithmetic-expression.jsp
WebContent\WEB-INF\view\arithmetic-expression-sepl.jsp
WebContent\WEB-INF\view\messages.tld

* Javascript/JQuery, Ajax, JSON :
WebContent\resouces\js

* CSS3 and HTML5 :
WebContent\resouces\css
WebContent\WEB-INF\view\arithmetic-expression.jsp
WebContent\WEB-INF\view\arithmetic-expression-sepl.jsp

* JPA/Hibernate with h2 DB :
resources\hibernate.cfg.xml
com\pegasus\arithmetic\expression\dao\ArithmeticExpressionDAOImpl.java
com\pegasus\arithmetic\expression\commons\HibernateUtil.java

* Maven POM : 
pom.xml

To get the code:
-------------------
Clone the repository:

    $ git clone git://github.com/dhirajrathod/arithmetic-expression.git

Steps To run the application :
-------------------
* Checkout or download the project from github.
* Import this project in Eclipse Using Existing Project.
* Now clean the project and build it.
* Now run the project.

For localhost URL will be like :
-------------------
    http://localhost:8080/arithmetic-expression
