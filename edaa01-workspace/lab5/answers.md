# Laboration 5 – binära sökträd

## Förberedelser

### F1.

a. Vad skrivs ut ut om trädets element skrivs ut i inorder?

**Svar**:

```java
10 20 30 47
```

b. Vilken höjd har trädet?

**Svar**: 2

c. Vilken höjd får trädet om 42 sätts in?

**Svar**: 3

### F2.

a. Om trädet är tomt är höjden `0`, annars är höjden 1 + <sup>2</sup>`log(n+1)`

b. Sök i dokumentationen av klassen Math på nätet. Med vilken metod kan man få det största värdet av två heltal?

**Svar**:

```java
Math.max(double a, double b)
```

### F3.

Repetera algoritmen för binärsökning från föreläsningen om rekursion. I uppgift D7 kommer du i att kunna hämta inspiration från den algoritmen. Den rekursiva metoden har
parametrar first och last för att hålla reda på i vilken del av vektorn man söker. Hur beräknar man mitten i intervallet [first, last]?

**Svar**:

```java
int mid =  last + first / 2;
```
