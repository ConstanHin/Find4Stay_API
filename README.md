# Find4Stay_API

Parte de backent del proyecto Find4Stay

## Base de datos

### Diagrama entidad relación

![image](https://user-images.githubusercontent.com/67373492/171733469-1b6af00b-0611-4800-be4e-0e6218a46805.png)

La Reserva solo se pueden añadir si se le pasa también un Cliente y un Hotel.
Si se elimina el Hotel o el Cliente la foreign key correspondente de Reserva se setea en NULL.
