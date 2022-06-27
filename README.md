# Find4Stay_API

Parte de backent del proyecto Find4Stay

## Base de datos

### Diagrama entidad relación


![image](https://user-images.githubusercontent.com/67373492/171733469-1b6af00b-0611-4800-be4e-0e6218a46805.png)

La Reserva solo se pueden añadir si se le pasa también un Cliente y un Hotel.
Si se elimina el Hotel o el Cliente la foreign key correspondente de Reserva se setea en NULL.

## Security

### Restringir los endpoints por roles

#### Roles principales

|Role|
|-----|
|ROLE_ADMIN|
|ROLE_CLIENTE|
|ROLE_EMPRESA|

#### Como restringir por rol

Para restringir el acceso a un endpoint por rol, dentro de los controllers, encima de los metodos, se tiene que añadir:

~~~~
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
~~~~

De este modo en el archivo "HotelController.java":

~~~~

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/hoteles")
	public List<Hotel> listarHotel(){
		return HotelServiceImpl.listarHotel();
	}
  
~~~~

Para añadir mas de un rol a un endpoin se haría del siguiente modo:

~~~~
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CLIENTE')")
~~~~

Teoria - Empresa buscar sus propios hoteles

![image](https://user-images.githubusercontent.com/67373492/171840726-21d900dd-1ec8-442c-b73b-b35145ff292a.png)

## Endpoints

### GET - "/api/hoteles/empresa"  
Devuelve los **hoteles de la empresa autenticada**. Accesible solo con una cuenta con **ROLE_EMPRESA**.

### GET - "/api/file/add/{id}"

![diagrama entidad relacion base de datos](https://user-images.githubusercontent.com/67373492/170439093-f2eb62a6-49af-487c-9e8e-79d8b737789f.png)

