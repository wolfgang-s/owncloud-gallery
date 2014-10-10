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

## License

GPLv3

Copyright (C) 2014  Wolfgang Steuer

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
