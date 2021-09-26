# reto-kruger
Proyecto reto para kruger

# El proyecto consta de 2 subproyectos
0. proyecto cmd_inventory_vaccination : el cual es el modelo entidad relacion, el cual tiene las siguientes caracteristicas
- Modelo entidad relacion en Power Designer
- Modelo Físico relacional en Power Designer
- Script de base de datos generado y modificado desde Power Designer
- Imagen de modelo extraido desde la bdd con cliente Dbeaer

1. proyecto inventoty-api : el cual es el backend realizado en springboot el cual tiene las siguientes caracteristicas
- Base de datos Postgresql
- Framework java springboot
- Uso de Liquibase para multiples llamadas a esquemas de base de datos
- Uso de Swagger
- Uso de Oauth2
- Uso de Login con redes sociales: Google y Facebook
- Uso de aseguramiento de endpoint por medio de roles
- Uso de JWT firmado para autorizaciones

2. proyecto inventory-ui: el cual  es el frontend realizado con angular 12 el cual tiene las siguientes caracteristicas
- Framework de JS Angular 12
- Framework para estilos, Adminltio, Bootstrap, PrimeNg
- Uso de librerias ServiceAutentication para redes sociales Google y Facebook
- Uso de autenticacion por medio de email y password
- Uso de Guard para accesos a rutas especificas
- Uso de Inetrceptores para vincular los JWT a las peticiones luego del logeo
- Uso de TIDO para recibir mensajes de sugerencias en tiempo real
- Uso de i18n pra Multilenguaje
- Uso de plantilla básica para acelerar el desarrollo del frontend

NOTAS IMPORTANTES:
- El proyecto lastimosamente no pudo ser terminado en su totalidad con backend y frontend debido
- Se cubrió la mayoría de aspectos requeridos en el reto para el frontend
- Se cuvbrieron todsos los aspectos solicitados en el reto para el backend

