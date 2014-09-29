owncloud-gallery
================

A native mobile app for iOS and Android based on robovm which connects to ownCloud 6 or 7 and displays thumbnails of your pictures. This will save you a lot of bandwidth and you will be able to show your latest holiday pictures just as you have them directly on your device.
This repository contains 3 projects:
- Android specific part (views, controllers, ...)
- iOS specific part (views, controllers, ...)
- Shared Java library (model, business logic, connectivity, data store, ...)

The first view commits will only show a prove of concept.

The hybrid app of this app is already published:

https://itunes.apple.com/de/app/owncloud-gallery-free/id892583417
https://play.google.com/store/apps/details?id=md.steuer.mobile.owncloud_gallery.free

but I'm not really satified with this none native hybrid solution because of performance and connectivity problems.

This is how the iOS views will be created from the interface builder:
http://blog.robovm.org/2013/02/robovm-interface-builder-integration.html

Help and improvements are welcome!
