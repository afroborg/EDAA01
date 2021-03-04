# Laboration 3 – grafiska användargränssnitt

## Förberedelser

### F1. Läs igenom texten under rubriken ”Bakgrund”.

### F2. Sök upp dokumentationen för Map.Entry. Interfacet används för att beskriva ett par, av en nyckel och ett värde, i en Map. Bekanta dig med vilka metoder som finns i interfacet. Det finns en metod i Map för att hämta en mängd (Set) av sådana Map.Entry-objekt. Vad heter metoden?

**Svar**:

```java
Map.entrySet()
```

### F3. Anta nu att vi har en lista (inte en mängd) av Map.Entry enligt ovan, med typargumenten `<String, Integer>`. Vi vill använda den inbyggda metoden sort för att sortera listan, i fallande ordning, med avseende på värden (inte nycklar). Fyll i lambdauttrycket nedan så att ordningen blir den önskade.

**Svar**:

```java
List<Map.Entry<String, Integer>> list = ...; // listan skapas
list.sort((e1, e2) -> e2.getValue() - e1.getValue());
```

### F4. Sök upp dokumentationen för följande Java-klasser på nätet JButton, JTextField, JPanel och JList.

a. Med vilken metod anges vilken kod som ska köras när en JButton klickas?

**Svar**:

```java
AbstractButton.addActionListener();
```

b. Vilken metod returnerar texten som användaren har skrivit i ett JTextField?

**Svar**:

```java
JTextComponent.getText();
```

c. Med vilken metod lägger man till ett element i en JPanel?

**Svar**:

```java
Container.add(Component comp);
```

d. Vilken metod använder man för att markera en viss rad i en JList?

**Svar**:

```java
JList.setSelectedIndex​(int index);
```

### F5. Lös uppgifterna D1, D2, D3 och D4.

### F6. Läs igenom övriga uppgifter.

## Datorarbete
