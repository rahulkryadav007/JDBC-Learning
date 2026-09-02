# 09 - Transactions

A transaction groups multiple database operations into one logical unit.

### Real-life example
Bank transfer:
1. Money is deducted from Account A.
2. Money is added to Account B.

If step 2 fails, step 1 must also be undone. This is where **rollback** matters.

## JDBC methods

```java
con.setAutoCommit(false);
con.commit();
con.rollback();
```

### Flow

```text
BEGIN
  ↓
Operation 1
  ↓
Operation 2
  ↓
Everything OK? ── Yes → COMMIT
       |
       No
       ↓
    ROLLBACK
```

See `BankTransfer.java`.

### Practice
Create an `accounts` table and implement a transfer between two accounts. Test both success and failure cases.
