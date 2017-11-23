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