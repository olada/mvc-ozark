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
Setup Glassfish 5 in your IDE (e.g. IntelliJ IDEA).
Noteworthy for IntelliJ: Make sure, that you build the war files using `mvn package`.
Once the server is running and the war files are deployed, following endpoints can be navigated to:
* Tech@-Planner: http://localhost:8080/tech-at-planner

## Example Configuration in IntelliJ IDEA
![Run Configuration #1](slides/images/C:\dev\cofinpro\java-jens-tech@\mvc-ozark\slides\images\2017-12-11 22_54_39-Run_Debug Configurations.png)