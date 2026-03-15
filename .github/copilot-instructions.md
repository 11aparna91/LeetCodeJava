# Copilot / AI agent instructions for LeetCodeJava

Purpose: quickly orient an AI coding assistant to be productive in this small repository of Java LeetCode solutions.

- **Repo shape (big picture):** a flat collection of single-solution Java files at the repo root. Each file implements a LeetCode-style solution method (often inside a `Solution`, `Sol`, or problem-named class). Examples: [AddString.java](AddString.java), [twoSum.java](twoSum.java), [sum-of-square-numbers.java](sum-of-square-numbers.java), [ugly-number.java](ugly-number.java).

- **Why this shape:** files were copied from LeetCode submissions — they assume LeetCode's execution harness (no `main`, sometimes missing imports). Keep one solution per file when editing unless adding a local test harness.

- **Common patterns to follow:**
  - Method signatures match LeetCode API (e.g., `public int[] twoSum(int[] nums, int target)`) — do not change the public method name/parameters unless intentionally refactoring for a local test harness.
  - Class names vary: some files use `class Solution`, others `class Sol`, or problem-specific names (see `AddString.java` uses `Sol`; `twoSum.java` defines `public class twoSum`). Check the declared class name before compiling/running.

- **Known quirks / pitfalls (from code):**
  - Some files assume LeetCode environment and miss standard imports. Example: `twoSum.java` uses `Map`/`HashMap` but lacks `import java.util.Map; import java.util.HashMap;` — add imports when compiling locally.
  - Filenames sometimes contain hyphens (e.g., `sum-of-square-numbers.java`) while classes inside are named `Solution` — these are fine so long as no `public` class requires matching filename.

- **Local build & run workflow (how I test code locally):**
  1. Compile everything to surface syntax/import errors:

```bash
javac *.java
```

2. To run a specific solution, create a tiny driver `Main` that calls the method and compile both files. Example workflow for testing `AddString.java` (it defines class `Sol`):

```bash
cat > Main.java <<'EOF'
public class Main {
  public static void main(String[] args) {
    System.out.println(new Sol().addStrings("123", "456"));
  }
}
EOF
javac Main.java AddString.java
java Main
```

Or use `jshell` for quick experiments:

```bash
jshell --class-path .
// then new Sol().addStrings("1","2")
```

- **When modifying files:**
  - Preserve the LeetCode method signature unless adding a separate local driver or tests.
  - Add missing `import` lines (e.g., `java.util.*`, `java.math.BigInteger`) as needed rather than changing APIs.
  - Prefer adding a `tests/` or `tools/` folder with driver classes if you add multiple local test harnesses rather than changing the original solution files.

- **If you add CI or a build system:**
  - Move sources to `src/` and add a `pom.xml`/`build.gradle` (optional). For minimal checks, a GitHub Action that runs `javac *.java` is sufficient to catch compile errors.

- **Examples from repo to reference:**
  - `AddString.java` — uses `BigInteger`, class named `Sol`. ([AddString.java](AddString.java))
  - `twoSum.java` — public class `twoSum`, missing `java.util` imports; method returns `int[]` matching LeetCode signature. ([twoSum.java](twoSum.java))

If anything above is unclear or you'd like the file reorganized into `src/` + tests/ + a GitHub Action, tell me which direction you prefer and I will update the repo accordingly.
