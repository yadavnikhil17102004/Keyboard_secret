# Encrypted Keyboard App

A secure Android keyboard that encrypts text input in real-time using a custom substitution cipher system.

## Features

### 1. Real-time Encryption
- Implements alternating substitution ciphers for enhanced security
- Encrypts text as you type
- Supports both letters and special characters
- Maintains a consistent encryption pattern

### 2. Decryption Activity
- Built-in decryption interface
- Real-time decryption preview
- Clipboard integration for easy text pasting
- Automatic decryption of pasted encrypted text

### 3. Custom Input Method Service
- Seamless integration with Android's input method framework
- Custom keyboard layout
- Efficient text processing
- Background encryption processing

## Technical Implementation

### Encryption Logic
- Uses multiple substitution ciphers that alternate based on character position
- Each character is transformed using a specific mapping algorithm
- Special handling for spaces and punctuation
- Maintains encryption consistency across sessions

### Decryption Module
- Implements reverse cipher algorithms
- Handles clipboard operations for encrypted text
- Updates decrypted output in real-time
- Error handling for invalid encrypted input

## Setup Guide

### Prerequisites
- Android Studio installed
- Android device/emulator with API 21+

### Installation Steps
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

## Usage Instructions

### Keyboard Activation
1. Open device Settings
2. Navigate to System > Languages & input > Virtual keyboard
3. Enable "Encrypted Keyboard" in keyboard list
4. Select as default input method when prompted

### Using the Keyboard
1. Open any text input field
2. Long-press the input field
3. Select 'Input method' from context menu
4. Choose 'Encrypted Keyboard'
5. Type normally - text will be automatically encrypted

### Using the Decryption Feature
1. Launch the Decryption Activity
2. Paste encrypted text using the paste button
3. View the decrypted result instantly
4. Copy decrypted text as needed

## Testing
1. Type "HELLO WORLD" in any app
2. Should output: "*%++> ςορλδ"
3. Use Decryption Activity to verify the original text

## Troubleshooting
- If keyboard doesn't appear: Recheck activation steps
- If symbols mismatch: Clean rebuild project
- For input lag: Test on physical device
- If decryption fails: Ensure complete encrypted text is pasted

## Security Notes
- The encryption is designed for basic text security
- Not recommended for highly sensitive information
- Always use additional security measures for critical data