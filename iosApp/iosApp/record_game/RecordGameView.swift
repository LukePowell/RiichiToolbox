//
//  RecordGameView.swift
//  iosApp
//
//  Created by Luke Powell on 7/17/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class RecordGameModel: ObservableObject {
    @Published var game = Game(startingPoints: 25_000, targetPoints: 30_000)
}

struct RecordGameView: View {
    let game: RecordGameModel

    var body: some View {
        VStack(spacing: 25) {
            PlayerView(playerData: PlayerData(wind: .west, name: "Akagi", points: Int(game.game.startingPoints)))
                .rotationEffect(Angle(degrees: 180))
            HStack {
                PlayerView(playerData: PlayerData(wind: .north, name: "Akagi", points: Int(game.game.startingPoints)))
                    .rotationEffect(Angle(degrees: 90))
                RoundDataView(roundDataModel: RoundDataModel())
                PlayerView(playerData: PlayerData(wind: .south, name: "Akagi", points: Int(game.game.startingPoints)))
                    .rotationEffect(Angle(degrees: 270))
            }
            PlayerView(playerData: PlayerData(wind: .east, name: "Akagi", points: Int(game.game.startingPoints)))
        }
    }
}

struct RecordGameView_Previews: PreviewProvider {
    static var previews: some View {
        RecordGameView(game: RecordGameModel())
    }
}
