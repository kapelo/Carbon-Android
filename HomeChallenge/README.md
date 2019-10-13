## Setup
1. Download and Install Android Studio: Go to https://developer.android.com/studio/install and follow the steps related to your OS
2. Include SDK path to PATH: Go to [How to set Android SDK path](https://www.dev2qa.com/how-to-set-android-sdk-path-in-windows-and-mac/) and follow the steps related to your OS
3. Launch Emulator with Genymotion:
   - Go to https://www.genymotion.com/account/create/ to create an account with Genymotion
   - Go to https://www.genymotion.com/download/ to download
   - Install and launch Genymotion
   - Download device emulator with Android version 6 and above
4. Installing NODEJS and setting up NODE_HOME environment variable: 
   - Make sure NODEJS is installed on the PC
   - Get the path of the folder where the NODEJS is installed to e.g. for MacOS the nodeJS full path is /usr/local/bin/node, so, the path we need here is /usr/local
   - Set an environment variable NODE_HOME to the path you’ve copied e.g NODE_HOME=/usr/local . Refer to step 2 above on how to set environment variable.
5. Install Appium JavaScript package: npm install -g appium

## Run Test
1. Download executable jar [file](https://drive.google.com/open?id=1_j4Wqr4Yz5riAoerAwsfSVADuwM44BSD) to use in running test in step 4
2. Launch downloaded android emulator in Genymotion or any android emulator if you have one
3. Navigate to project root folder i.e. HomeChallenge on your terminal
4. Paste “java -jar ./HomeChallenge-FM-1.0-SNAPSHOT.jar” in terminal and run

Here is a [link](https://drive.google.com/open?id=1OZEEsUEPmyGW9awiqtviC3SAB69jVpgH) to recorded test run. File size is about 326MB.
