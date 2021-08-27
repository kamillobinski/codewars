# Decode the Morse code

**NOTE:** Extra spaces before or after the code have no meaning and should be ignored.

In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the international distress signal [SOS](https://en.wikipedia.org/wiki/SOS) (that was first issued by [Titanic](https://en.wikipedia.org/wiki/RMS_Titanic)), that is coded as `···−−−···`. These special codes are treated as single special characters, and usually are transmitted as separate words.

Your task is to implement a function that would take the morse code as input and return a decoded human-readable string.

For example:

```java
MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
//should return "HEY JUDE"
```

**NOTE:** For coding purposes you have to use ASCII characters `.` and `-`, not Unicode characters.

The Morse code table is preloaded for you as a dictionary, feel free to use it:

- Coffeescript/C++/Go/JavaScript/Julia/PHP/Python/Ruby/TypeScript: `MORSE_CODE['.--']`
- C#: `MorseCode.Get(".--")` (returns `string`)
- F#: `MorseCode.get ".--"` (returns `string`)
- Elixir: `@morse_codes` variable (from `use MorseCode.Constants`). Ignore the unused variable warning for `morse_codes` because it's no longer used and kept only for old solutions.
- Elm: `MorseCodes.get : Dict String String`
- Haskell: `morseCodes ! ".--"` (Codes are in a `Map String String`)
- Java: `MorseCode.get(".--")`
- Kotlin: `MorseCode[".--"] ?: ""` or `MorseCode.getOrDefault(".--", "")`
- Racket: `morse-code` (a hash table)
- Rust: `MORSE_CODE`
- Scala: `morseCodes(".--")`
- Swift: `MorseCode[".--"] ?? ""` or `MorseCode[".--", default: ""]`

- C: provides parallel arrays, i.e. `morse[2] == "-.-"` for `ascii[2] == "C"`

- NASM: a table of pointers to the morsecodes, and a corresponding list of ascii symbols

All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.