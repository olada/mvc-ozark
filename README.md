# mvc-ozark

## Requirements
Following tools are installed:
* node.js and npm
* maven

## Project Checkout
Following commands need to be run once.
```
cd /path/to/your/project/folder
git clone https://github.com/olada/mvc-ozark.git .
git submodule init
git submodule update
npm install
npm --prefix ./presentation install ./presentation
```
## Run Presentation
Run `npm run presentation` in root project folder. 
A new browser tab should open automatically pointing to _localhost:8000_.

## Run MVC Projects
Setup ~~Glassfish 5~~ Wildfly 10.1.Final in your IDE and add the mvc subsystem according to https://github.com/gtudan/wildfly-ozark.
Noteworthy for IntelliJ: Make sure, that you build the war files using `mvn package`.
Once the server is running and the war files are deployed, following endpoints can be navigated to:
* Tech@-Planner: http://localhost:8080/tech-at-planner
* Sandbox: http://localhost:8080/sandbox

## To-Do:
* Unter Wildfly kann der HttpServletRequest nicht mehr injected werden. -> Fixen