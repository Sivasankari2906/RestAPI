# Online Banking REST API

Spring Boot + MySQL REST API for customers, accounts, loans, payments and employees, with Swagger docs and email sending.

## Configuration

No passwords are stored in the repo. Set these environment variables (see `.env.example`):

| Variable | Required | Description |
|---|---|---|
| `DB_PASSWORD` | yes | MySQL password. The app cannot connect to the database without it. |
| `DB_URL`, `DB_USERNAME` | no | Default to `jdbc:mysql://localhost:3306/db` and `root` |
| `MAIL_USERNAME`, `MAIL_PASSWORD` | for `/mail` | Gmail address and app password |

```bash
cd BankApp
export DB_PASSWORD='your-mysql-password'
./mvnw spring-boot:run
```

## Keeping secrets out of the repo

```bash
brew install gitleaks                 # open-source secret scanner
git config core.hooksPath .githooks   # run once per clone
```

Every commit is scanned, and `.gitleaks.toml` also catches literal passwords in config files.
