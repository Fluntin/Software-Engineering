# Particle Simulation Project

Welcome to our Particle Simulation project! This is an exciting journey into the world of computational physics and computer graphics, where we explore the fascinating concept of Brownian motion through a Java-based simulation.

## Introduction to Brownian Motion

Brownian motion, named after the botanist Robert Brown, is the random movement observed in particles suspended in a fluid (like gas or liquid). This phenomenon is a cornerstone in the field of statistical mechanics and has vast applications in physics, chemistry, and beyond.

## The Problem

Understanding and visualizing Brownian motion can be challenging due to its random and dynamic nature. Traditional mathematical models are often complex and not intuitive for visual learners. Our goal was to create an interactive simulation that makes it easier to visualize and understand how particles behave in Brownian motion.

## Our Solution: A Java-Based Simulation

We developed a Java program that simulates thousands of particles moving randomly, mimicking the behavior seen in Brownian motion. Here's a rundown of what our project offers:

### Dynamic Particle Movement
- **Random Particle Movement**: Each particle moves based on a random angle, demonstrating the unpredictability inherent in Brownian motion.

### Interactive User Interface
- **Control Panel**: Adjust the simulation speed and random movement length through a user-friendly interface.

### Collision and Boundary Handling
- **Edge Interactions**: Particles that reach the boundary of the simulation window "stick" to it, changing color and becoming stationary, showcasing particle interaction with boundaries.

### Scalable and Efficient
- **Optimized for Large Numbers of Particles**: Our approach efficiently handles collisions, ensuring the simulation remains fluid even with over 10,000 particles.

## How It Works

- `Particle`: The core entity representing each moving particle.
- `ParticleModel`: Manages all the particles, updating their states as per Brownian dynamics.
- `ControlPanel`: Allows users to interact with and control the simulation parameters.
- `SimulationView`: Renders the particles and handles their interactions with boundaries.
- `ParticleSimulation`: Coordinates the simulation loop, ensuring continuous animation.

## Running the Simulation

1. Clone this repository to your local machine.
2. Compile the Java files.
3. Execute the `SimulationView` class to start the simulation.

```bash
javac *.java
java SimulationView
```

## Dive Into the Code

We encourage you to explore the code, tweak parameters, and see how the behavior of the particles changes. It's a great way to get hands-on experience with the principles of Brownian motion and computational simulations.

## Conclusion

This project serves as a bridge between theoretical physics and practical visualization. By interacting with the simulation, students can gain a deeper understanding of Brownian motion and appreciate the beauty of physics in motion.

Thank you for exploring our Particle Simulation project!

---