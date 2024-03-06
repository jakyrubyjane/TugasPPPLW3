
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private  Owner owner;
    private List<Card> cards = new ArrayList<>();
    private Double cash;

    public Wallet(Owner owner, List<Card> cards, Double cash)  {
        this.owner = owner;
        this.cards = cards;
        this.cash = cash;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public  Double Withdraw(Double amount) {
        if (this.cash < amount) {
            System.out.println("SALDO ANDA TIDAK CUKUP");
            return  0.0;
        } else {
            this.cash -= amount;
            return amount;
        }
    }

    public Double  Deposit(Double amount) {
        this.cash += amount;
        return this.cash;
    }

    public void addCards(String bank, Integer accountNumber) {
        Card newCard = new Card(owner.getNama(), accountNumber);
        newCard.setNamaBank(bank);
        cards.add(newCard);
    }

    public void removeCard(Integer accountNumber) {
        List<Card> cardsToRemove = new ArrayList<>();
        for (Card card : this.cards) {
            if (card.getNoRek().equals(accountNumber)) {
                cardsToRemove.add(card);
            }
        }
        this.cards.removeAll(cardsToRemove);
    }


    @Override
    public String toString() {
        return "Wallet{" +
                "owner=" + owner +
                ", cards=" + cards +
                ", cash=" + cash +
                '}';
    }
}
