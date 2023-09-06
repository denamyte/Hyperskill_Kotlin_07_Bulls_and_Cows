fun parseCardNumber(cardNumber: String) =
    if (cardNumber.matches(Regex("(\\d{4} ){3}\\d{4}")))
        cardNumber.filter { it != ' ' }.toLong()
    else throw NumberFormatException("$cardNumber is not a valid card number")
