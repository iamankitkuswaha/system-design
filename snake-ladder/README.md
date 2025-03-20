# Snake and Ladder Game

Welcome to the Snake and Ladder Game project! This is a simple implementation of the classic board game Snake and Ladder using Java. The project is designed to be modular, easy to understand, and extendable.

## Table of Contents
- [Overview](#overview)
- [Classes and Interfaces](#classes-and-interfaces)
- [How to Play](#how-to-play)

## Overview
The Snake and Ladder Game is a digital version of the traditional board game. Players roll a dice to move their tokens across the board, climbing ladders to advance and sliding down snakes to fall back. The first player to reach the final position wins the game.

This project is implemented in Java and follows object-oriented principles to ensure modularity and scalability.

## Classes and Interfaces

### `Board`
- Represents the game board.
- Contains maps for snakes and ladders.
- Implements the Singleton pattern to ensure only one instance of the board exists.

### `Command` Interface
- Defines the `execute` method for command pattern implementation.

### `MoveCommand`
- Implements the `Command` interface.
- Represents a move command executed by a player.

### `DiceRollStrategy` Interface
- Defines the `roll` method for different dice rolling strategies.

### `StandardDiceRollStrategy`
- Implements the `DiceRollStrategy` interface.
- Provides a standard dice roll (1-6).

### `Snake`
- Represents a snake on the board with a head and tail position.

### `Ladder`
- Represents a ladder on the board with a foot and head position.

### `Game`
- Manages the game state, including players and their turns.

### `Observer` Interface
- Defines the `update` method for observer pattern implementation.

### `Player`
- Represents a player in the game.
- Implements the `Observer` interface to receive updates.

## How to Play
1. **Initialize the Game**: Create a `Game` instance and add players.
2. **Set Up the Board**: Add snakes and ladders to the `Board` instance.
3. **Roll the Dice**: Players take turns rolling the dice using the `StandardDiceRollStrategy`.
4. **Move the Player**: Execute the `MoveCommand` to move the player's token.
5. **Check for Snakes and Ladders**: If a player lands on a snake's head, they slide down to the tail. If they land on a ladder's foot, they climb up to the head.
6. **Win the Game**: The first player to reach the final position on the board wins.