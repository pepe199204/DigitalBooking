# DigitalBooking

Digital Booking es un sitio para buscar y reservar alojamientos. 

El frontend de este proyecto esta construido en React.

## Tabla de contenido

- [Requisitos](#requisitos)
- [Extensiones recomendadas para Visual Studio Code](#extensiones-recomendadas-para-visual-studio-code)
- [Configuración](#configuraci%C3%B3n)
- [Desarrollo](#desarrollo)
- [Comandos de la aplicación](#comandos-de-la-aplicaci%C3%B3n)
- [Convenciones](#convenciones)
- [Entendiendo la estructura de carpetas](#entendiendo-la-estructura-de-carpetas)


## Requisitos

- [Node.js 18.x](https://nodejs.org/en/)

## Extensiones recomendadas para Visual Studio Code

- [Jest](https://marketplace.visualstudio.com/items?itemName=Orta.vscode-jest)
- [Prettier - Code formatter](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)
- [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client) - Alternativa a Postman.


## Configuración


1. Ubicarse en el directorio correcto

```
cd frontend
```

2. Instalar las dependencias necesarias para el proyecto

```
npm install
```

## Desarrollo

- Servir la aplicación localmente:

```bash
$ npm run start
```

La aplicación se iniciará en [http://localhost:3000](http://localhost:3000)

## Comandos de la aplicación

```bash
$ # Compila el código de la aplicación.
$ npm run build

$ # Ejecuta ESLint para examinar el código de la aplicación en búsqueda de
$ # errores de sintaxis y prácticas inapropiadas.
$ npm run lint

$ # Ejecuta Prettier para formatear el código de la aplicación segun las reglas configuradas en el archivo .prettierrc
$ npm run format

$ # El proyecto utiliza Sass, con este comando estara observando cualquier cambio en los archivos .scss y los compilara a .css
$ npm run build-sass

```
## Convenciones

- [Commits Convencionales](https://www.conventionalcommits.org/en/v1.0.0/): esta especificación se aplica a los mensajes de los commits. Proporciona un conjunto de reglas para crear un historial de commits legible para máquinas y humanos.

## Entendiendo la estructura de carpetas

### Archivos de directorio src

- `index.js` : Es el corazón del proyecto, se encuentran importados todos los recursos.

- `index.css` : Es el css general de la aplicación.

- `App.js` : Componente app de react

- `App.css`: Es el css que se va a aplicar al componente App de React.

- `Components`: Es el directorio donde se encuentran todos los componentes.

- `services`: Es el directorio donde se encuentran todas las llamadas a la API.
