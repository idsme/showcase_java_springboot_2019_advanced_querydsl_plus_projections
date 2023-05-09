# ShowCase of Rest Perfect implementaitoion.
* JAVA/SPRING 2 plus
* QueryDSL
* Spring Projections 

## Conclusion
I learned a lot more about REST during this showcase then expected. Additionally, I will probably never code an API service and Models by hand on the SPA FE side again.
Further more BE Code was reduced by 80% and the implementation time at controller & repository level was cut to just a third.
Projections took the same amount of time as DTO's, but no unit tested where need. So adaptation is easier than with DTO's. Overall it liked this stack. And found it a great experience.

### Per Item Benefits
* Spring Data Rest really can be used to lower your code base dramatically. Creating a full CRUD API with just one Repository interface with some annotations.
* Spring Projections allow you to decouple your ORM domain model from your API model like DTO's. "But using interfaces".
* Using QueryDSL made the implementation more adaptable at repository level. Cutting implementation time 6 fold. No unit tests needed just E2E.

## REST as close to spec as possible: 
<img
  src="./ReferenceInformationEndpoint.png"
  alt="Saved then Saved with Error"
  title="The right way to do rest"
  style="display: inline-block; margin: 0 auto; max-width: 300px">

## Json/SOAP certainly not REST :
<img
  src="./NotRest_ButJson_Soap.jpg"
  alt="Json/SOAP not Rest"
  title="The wrong way to do rest"
  style="display: inline-block; margin: 0 auto; max-width: 300px">