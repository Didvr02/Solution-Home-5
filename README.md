# Design Patterns Homework - Real-World Implementations

This repository contains the code implementation for the Proxy and Flyweight design patterns based on the provided real-world scenarios for the homework assignment.

## 1. Proxy Pattern – Real Estate Image Management System

### Code Implementation

The code for the Proxy pattern can be found in the following Java files:

* `Image.java`: Interface for image display.
* `RealImage.java`: Concrete implementation of a high-resolution image.
* `ProxyImage.java`: Proxy class that delays loading the real image.
* `Agent.java`: Represents a user with login status (for the bonus).
* `ImageUploader.java`: Interface for image upload and replacement (for the bonus).
* `ProtectedImageProxy.java`: Proxy that controls access to image upload and replacement.
* `ProxyPatternDemo.java`: Demonstrates the usage of the Proxy pattern.

*(You can find the full code for these files in the previous responses.)*

### Explanation

**What problem was solved?**

In the context of the real estate image management system, the Proxy pattern addressed the issue of **inefficient loading and display of high-resolution images**. Loading all high-resolution images upfront for numerous property listings would lead to slow initial page load times and excessive resource consumption (bandwidth, memory) on the client-side, even if the user only viewed thumbnails.

**How did the pattern simplify or optimize the design?**

The Proxy pattern **optimized the design** by introducing the `ProxyImage` object, which acts as an intermediary for the `RealImage`. `ProxyImage` is lightweight and only loads image metadata (e.g., for displaying a thumbnail). The heavyweight `RealImage` object (containing the full-resolution image) is created and loaded into memory only when it's truly needed (e.g., when a user clicks to zoom). This implements **lazy loading**, which improves performance and reduces resource consumption. The bonus implementation of `ProtectedImageProxy` also **simplified the design** by adding access control (authorizing agents to upload and replace images) without modifying the core image handling logic, delegating these tasks to the proxy object.

## 2. Flyweight Pattern – Map Application Location Markers

### Code Implementation

The code for the Flyweight pattern can be found in the following Java files:

* `MarkerStyle.java`: Represents the shared (intrinsic) style of a marker.
* `MarkerStyleFactory.java`: Factory class to create and manage shared `MarkerStyle` objects.
* `LocationMarker.java`: Represents an individual location marker with unique (extrinsic) state.
* `FlyweightPatternDemo.java`: Demonstrates the usage of the Flyweight pattern.

*(You can find the full code for these files in the previous responses.)*

### Explanation

**What problem was solved?**

In the map application scenario, the Flyweight pattern tackled the problem of **high memory consumption** when rendering a large number of location markers (thousands) that share a lot of common intrinsic state (e.g., icon type, color, label style). Creating a separate style object for each marker would result in significant data duplication and inefficient memory usage.

**How did the pattern simplify or optimize the design?**

The Flyweight pattern **optimized the design** by separating the object's state into intrinsic (shared) and extrinsic (unique). The intrinsic state (marker style) was extracted into the `MarkerStyle` class, and the `MarkerStyleFactory` ensures that only unique instances of styles are created and stored. The `LocationMarker` objects now only store their unique state (name, coordinates) and a reference to the appropriate shared `MarkerStyle` object. This significantly **reduced the number of style objects created**, leading to substantial memory savings, especially with a large number of markers. The design became more **organized** as the logic for managing shared styles is centralized in the factory.

