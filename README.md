# Android TV - Sync TV state with IFTTT
Sync the Android TV state (on / off) with a close light (such as a lightstrip)

Using this open-source project, you can sync your Android TV with the lights of your smart home (such as Yeelight, Philips Hue…). In fact, you can make the tv turn on or off a light close to the tv (for example, a LED lightstrip behind it or a near lamp), in order to create a better atmosphere when you're watching TV.
It works with the IFTTT Webhooks (if you don't know what is IFTTT, click [here](https://ifttt.com/).

## Configure IFTTT
1. Download IFTTT on your mobile phone and create an account
2. Create two new IFTTT Applet. In the field named **this** put a **Webhook** and select <em>Receive a web request</em>. In the text field, enter something as you wish (my suggestion is <em>turn_on_lights</em>.
3. In the second field, the one called **then**, insert the service related to your smart light provider (such as Yeelight, Philips Hue, Smart Life etc), select the light you want to sync and, in the options, turn it on.
4. Repeat the steps 2 and 3, but the web request should be opposite (for example <em>turn_off_lights</em>) and the action is to turn off the same light.
5. Go to the Webhooks section and copy your Webhook Key.

## Configure the app
1. After cloning this repository, navigate to **app/src/main/assets** and create a new file called **app_config.properties**
2. Copy the content of **app_config_sample.properties** and replace the values with the ones from your IFTTT configuration.
3. Run the app on your TV!

## Known issues
1. The app doesn't autorun after a complete power off of the device. This means that, after a system update or after a drop in electricity, you have to re-run the app after the boot (the problem is that the BroadcastReceiver doesn't call the BOOT_COMPLETED on Android TV after boot)
2. App icon needs to be changed
