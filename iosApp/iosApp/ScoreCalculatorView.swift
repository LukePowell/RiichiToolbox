import SwiftUI
import shared

struct ScoreCalculatorView: View {
    @State private var han:Int32  = 1
    @State private var fu:Int32  = 25
    @State private var kiriageMangan = true
    @State private var dealer = false
    
    var score: Score {
        ScoreCalculator.Companion().calculate(han: han, fu: fu, kiriageMangan: kiriageMangan)
    }
    
    var body: some View {
        VStack {
            Stepper(value: $han,
                    in: 1...13,
                          step: 1) {
                      Text("\(han) han")
                  }
            .padding(10)
            Stepper(value: $fu,
                    in: 20...110,
                          step: 10) {
                      Text("\(fu) fu")
                  }
            .padding(10)
            Toggle(isOn: $kiriageMangan) {
                Text("Kiriage Mangan")
            }
            .padding(10)
            Toggle(isOn: $dealer) {
                Text("Dealer")
            }
            .padding(10)
            if dealer {
                Text("\(score.getPayoutToDealerTsumo())")
                Text("\(score.getPayoutToDealerRon())")
            } else {
                Text("\(score.getPayoutToNonDealerTsumo().nonDealer)/\(score.getPayoutToNonDealerTsumo().dealer)")
                Text("\(score.getPayoutToNonDealerRon())")
            }
        }
    }
}

struct ScoreCalculatorView_Previews: PreviewProvider {
    static var previews: some View {
    ScoreCalculatorView()
    }
}
