# Everyday Furniture — Forge 1.18.2

## Version 1.1.0

Adds dining table, bar stool, kitchen island, wall cabinet, oven, microwave, dishwasher, trash bin, plate rack, and kitchen shelf.

Original, modelled household furniture for everyday Minecraft builds. This release includes 12 placeable decorative blocks: chair, table, sofa, bedside table, cabinet, lamp, bookshelf, kitchen counter, sink, toilet, fridge, and coffee maker.

## Compatibility
- Minecraft 1.18.2 / Forge 40.x / Java 17
- Client and dedicated server; no required third-party dependencies
- Includes block and item model JSON resources using vanilla texture references.

## Build
```bash
./gradlew clean build
```
The distributable JAR is written to `build/libs/everyday-furniture-forge-1.18.2-1.1.0+1.18.2.jar`.

## Culinary Dragons compatibility boundary

Everyday Furniture is intentionally a separate namespace (`everydayfurniture`) from Culinary Dragons (`culinarydragons`). It does **not** register food, drink, alcohol, fruit, recipes, or Culinary Dragons processing stations. In particular, the furniture mod does not duplicate `juicer`, `blender`, `fermenter`, or `cooking_pot`; those remain owned by Culinary Dragons. The kitchen furniture is decorative infrastructure around those stations and can be installed with or without Culinary Dragons.

Compatibility audit: Culinary Dragons registry names were checked against the furniture registry before this release. There are no duplicate IDs or cross-mod resource paths.

This is an original implementation. Interaction features (functional storage, seating, appliances) are planned follow-up scope; the current release is placeable decorative furniture.
