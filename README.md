# Encrypted Keyboard App Setup Guide

## Prerequisites
- Android Studio installed
- Android device/emulator with API 21+

## Installation Steps
1. **Clone Repository**
   ```
   git clone [repository-url]
   ```
2. **Open in Android Studio**
   - Select 'Open an Existing Project'
   - Choose the project directory

3. **Build Project**
   - Click 'Build > Make Project'
   - Resolve any dependency issues if they occur

4. **Run on Device/Emulator**
   - Select target device from toolbar
   - Click 'Run > Run app'

## Keyboard Activation
1. Open device Settings
2. Navigate to System > Languages & input > Virtual keyboard
3. Enable "Encrypted Keyboard" in keyboard list
4. Select as default input method when prompted

## Usage Instructions
1. Open any text input field
2. Long-press the input field
3. Select 'Input method' from context menu
4. Choose 'Encrypted Keyboard'

## Testing the Encryption
1. Type "HELLO WORLD" in any app
2. Should output: "*%++> ςορλδ"

## Troubleshooting
- If keyboard doesn't appear: Recheck activation steps
- If symbols mismatch: Clean rebuild project
- For input lag: Test on physical device