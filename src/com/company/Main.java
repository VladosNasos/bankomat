import java.util.*;

// Основное исключение для всех проблем, связанных с банкоматами
class ATMException extends Exception {
    public ATMException(String message) {
        super(message);
    }
}

// Другие исключения
class InsufficientFundsException extends ATMException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidDenominationException extends ATMException {
    public InvalidDenominationException(String message) {
        super(message);
    }
}

class ExceedsWithdrawalLimitException extends ATMException {
    public ExceedsWithdrawalLimitException(String message) {
        super(message);
    }
}

class ATMInitializationException extends ATMException {
    public ATMInitializationException(String message) {
        super(message);
    }
}

class BankInitializationException extends ATMException {
    public BankInitializationException(String message) {
        super(message);
    }
}

class UserInputException extends ATMException {
    public UserInputException(String message) {
        super(message);
    }
}

class NullATMException extends ATMException {
    public NullATMException(String message) {
        super(message);
    }
}

class NegativeAmountException extends ATMException {
    public NegativeAmountException(String message) {
        super(message);
    }
}

class DenominationNotAvailableException extends ATMException {
    public DenominationNotAvailableException(String message) {
        super(message);
    }
}

class EmptyATMListException extends ATMException {
    public EmptyATMListException(String message) {
        super(message);
    }
}

// Класс ATM
class ATM {
    private Map<Integer, Integer> denominations;
    private int minWithdrawalAmount;
    private int maxNotesLimit;

    public ATM(int minWithdrawalAmount, int maxNotesLimit) throws ATMInitializationException {
        if (minWithdrawalAmount <= 0 || maxNotesLimit <= 0) {
            throw new ATMInitializationException("Invalid initialization parameters.");
        }
        this.denominations = new HashMap<>();
        this.minWithdrawalAmount = minWithdrawalAmount;
        this.maxNotesLimit = maxNotesLimit;
    }

    public void initializeATM(int[] notes) throws InvalidDenominationException, ATMInitializationException {
        if (notes == null || notes.length == 0) {
            throw new ATMInitializationException("No denominations provided for initialization.");
        }
        try {
            for (int denomination : notes) {
                if (denomination <= 0) {
                    throw new InvalidDenominationException("Invalid denomination: " + denomination);
                }
                denominations.put(denomination, 0);
            }
        } catch (Exception e) {
            throw new ATMInitializationException("Error during ATM initialization: " + e.getMessage());
        }
    }

    public void deposit(int denomination, int count) throws InvalidDenominationException, DenominationNotAvailableException, NegativeAmountException {
        if (count < 0) {
            throw new NegativeAmountException("Cannot deposit a negative number of banknotes.");
        }
        if (!denominations.containsKey(denomination)) {
            throw new DenominationNotAvailableException("This denomination is not available in this ATM: " + denomination);
        }
        denominations.put(denomination, denominations.get(denomination) + count);
    }

    public int withdraw(int amount) throws InsufficientFundsException, ExceedsWithdrawalLimitException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (amount < minWithdrawalAmount) {
            throw new InsufficientFundsException("Amount less than minimum withdrawal limit.");
        }

        Map<Integer, Integer> toWithdraw = new HashMap<>();
        int totalNotes = 0;

        for (int denomination : denominations.keySet()) {
            int count = Math.min(amount / denomination, denominations.get(denomination));
            toWithdraw.put(denomination, count);
            amount -= denomination * count;
            totalNotes += count;

            if (totalNotes > maxNotesLimit) {
                throw new ExceedsWithdrawalLimitException("Exceeds the maximum limit of notes that can be dispensed.");
            }
        }

        if (amount > 0) {
            throw new InsufficientFundsException("Insufficient funds in ATM to complete this transaction.");
        }

        for (int denomination : toWithdraw.keySet()) {
            denominations.put(denomination, denominations.get(denomination) - toWithdraw.get(denomination));
        }

        return totalNotes;
    }

    public int getTotalMoney() {
        return denominations.entrySet().stream().mapToInt(e -> e.getKey() * e.getValue()).sum();
    }

    public void displayDenominations() {
        System.out.println("Current denominations in ATM:");
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            System.out.println("Denomination: " + entry.getKey() + " - Count: " + entry.getValue());
        }
    }
}

// Класс Bank
class Bank {
    private List<ATM> atms;
    private int atmCount;

    public Bank(int atmCount) {
        this.atms = new ArrayList<>();
        this.atmCount = atmCount;
    }

    public void initializeATMs(int minWithdrawalAmount, int maxNotesLimit) throws BankInitializationException, UserInputException {
        if (atmCount < 0) {
            throw new UserInputException("Number of ATMs cannot be negative.");
        }
        try {
            for (int i = 0; i < atmCount; i++) {
                atms.add(new ATM(minWithdrawalAmount, maxNotesLimit));
            }
        } catch (Exception e) {
            throw new BankInitializationException("Error initializing the ATM network.");
        }
    }

    public List<ATM> getATMs() {
        return this.atms;
    }

    public ATM getATM(int index) throws NullATMException {
        try {
            return atms.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NullATMException("ATM at this index does not exist.");
        }
    }

    public int getTotalMoneyInNetwork() throws EmptyATMListException {
        if (atms.isEmpty()) {
            throw new EmptyATMListException("No ATMs are available in the network.");
        }
        return atms.stream().mapToInt(ATM::getTotalMoney).sum();
    }

    public void loadMoneyInATMs(int[] denominations, int amountPerDenomination) throws ATMInitializationException, InvalidDenominationException, DenominationNotAvailableException, NegativeAmountException {
        for (ATM atm : atms) {
            atm.initializeATM(denominations);
            for (int denomination : denominations) {
                atm.deposit(denomination, amountPerDenomination);
            }
        }
    }
}

// Основной класс приложения
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of ATMs in the bank:");
            int atmCount = scanner.nextInt();

            Bank bank = new Bank(atmCount);

            System.out.println("Initializing ATMs...");
            bank.initializeATMs(50, 40); // Минимальная сумма для снятия и максимальное количество банкнот

            int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500};
            System.out.println("Loading money into ATMs...");
            bank.loadMoneyInATMs(denominations, 10); // Загрузка 10 банкнот каждого номинала

            boolean running = true;
            while (running) {
                try {
                    System.out.println("\nATM Menu:");
                    System.out.println("1. View total money in the network");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. Deposit money");
                    System.out.println("4. View ATM denominations");
                    System.out.println("5. Exit");
                    System.out.print("Choose an option: ");

                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Total money in network: " + bank.getTotalMoneyInNetwork());
                            break;
                        case 2:
                            System.out.println("Enter ATM number (0 to " + (atmCount - 1) + "): ");
                            int atmIndex = scanner.nextInt();
                            ATM atm = bank.getATM(atmIndex);
                            System.out.println("Enter amount to withdraw: ");
                            int amount = scanner.nextInt();
                            atm.withdraw(amount);
                            System.out.println("Money withdrawn successfully.");
                            break;
                        case 3:
                            System.out.println("Enter ATM number (0 to " + (atmCount - 1) + "): ");
                            atmIndex = scanner.nextInt();
                            atm = bank.getATM(atmIndex);
                            System.out.println("Enter denomination: ");
                            int denomination = scanner.nextInt();
                            System.out.println("Enter count: ");
                            int count = scanner.nextInt();
                            atm.deposit(denomination, count);
                            System.out.println("Money deposited successfully.");
                            break;
                        case 4:
                            System.out.println("Enter ATM number (0 to " + (atmCount - 1) + "): ");
                            atmIndex = scanner.nextInt();
                            atm = bank.getATM(atmIndex);
                            atm.displayDenominations();
                            break;
                        case 5:
                            running = false;
                            System.out.println("Exiting... Thank you for using our services!");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                } catch (ATMException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.");
                    scanner.next(); // очистить неправильный ввод
                }
            }
        } catch (ATMException | InputMismatchException e) {
            System.out.println("Error during initialization: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
