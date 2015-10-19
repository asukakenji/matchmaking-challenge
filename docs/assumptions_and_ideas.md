# Assumptions

### `playersPerTeam <= 8`

It sounds reasonable to make such an assumption.
Since if there are more than 16 players battling in an arena,
it soon becomes a battle royal / tangled warfare.
Players with higher attack points may probably win easily by making aimless attacks throughout the battle.



### `int` is sufficient to store `Player.wins` and `Player.losses`

```
No. of        Integer            Time needed
increments    type               to run out
per second    used               of values
----------    -------            -----------
1             signed 32-bit      68.0511 years
              unsigned 32-bit    136.102 years
              signed 64-bit      292 billion years
              unsigned 64-bit    585 billion years

100           signed 32-bit      248.551 days
              unsigned 32-bit    497.103 days
              signed 64-bit      2.92 billion years
              unsigned 64-bit    5.85 billion years

1000          signed 32-bit      24.8551 days
              unsigned 32-bit    49.7103 days
              signed 64-bit      292.277 million years
              unsigned 64-bit    584.555 million years

10000         signed 32-bit      2.48551 days
              unsigned 32-bit    4.97103 days
              signed 64-bit      29.2277 million years
              unsigned 64-bit    58.4555 million years
```

According to the table above,
even if it takes only 1 second to complete a battle (a game),
the player need to play more than 68 years without stopping,
and either winning them all or losing them all,
in order to exhaust the values.
That should be long enough for the life-time of a game!



# Ideas

### Calculations involving `Player.wins` and `Player.losses` should be handled with care

Since `Player.wins` and `Player.losses` are built-in integers,
they should be handled with care or overflow may occur and strange behaviors will probably follow.

For example, calculating the win rate directly from the definition may cause overflow:

```java
rate = wins / (wins + losses);
```

Although `java.math.BigInteger` could be used, it is expensive to do so and should be avoided as much as possible.
Fortunately, by transforming the formula, overflow could be eliminated:

```
rate = wins / (wins + losses)
     = 1 / [ (wins + losses) / wins ]
     = 1 / [ 1 + (losses / wins) ]
```

Here is how the win rate could be calculated using the transformed formula:

```java
rate = 1.0 / (1.0 + ((double) wins) / ((double) losses));
```


### Using the win rate alone to determine a player's skill level is not a good idea

Here are 2 players having the same win rate, but Player 1 is obviously the far better player:

```
Player 1           Player 2
---------------    --------------
    wins: 10000        wins: 1
  losses:     0      losses: 0
win rate:  100%    win rate: 100%
```

Therefore, the `Matchmaker` implementation should try its best to avoid "Player 1 vs Player 2" in a "1v1 match".
Besides, it should avoid grouping Player 1 and Player 2 in the same team.
Otherwise Player 1 will complain that the game sucks by grouping him with *dead wood*.



### Using the total number of wins and losses alone to group a team is not a good idea

Here is a match with total wins and losses matched perfectly:

```
Team 1                              Team 2
--------------------------------    --------------------------------
Player 1: wins: 898, losses:   0    Player 4: wins: 300, losses: 100
Player 2: wins:   1, losses: 150    Player 5: wins: 300, losses: 100
Player 3: wins:   1, losses: 150    Player 6: wins: 300, losses: 100
--------------------------------    --------------------------------
   Total: wins: 900, losses: 300       Total: wins: 900, losses: 300
```

In team 1, only Player 1 is in fact "functional".
Again, Player 1 will probably complain for *dead wood*.
