//
//  PlayerView.swift
//  iosApp
//
//  Created by Luke Powell on 7/17/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class PlayerData: ObservableObject {
    @Published var wind: Wind
    @Published var name: String
    @Published var points: Int
    
    init(wind: Wind, name: String, points: Int) {
        self.wind = wind
        self.name = name
        self.points = points
    }
}

struct PlayerView: View {
    let playerData: PlayerData
    
    init(playerData: PlayerData) {
        self.playerData = playerData
    }
    
    var body: some View {
        HStack {
            Text("\(playerData.wind.kanji)")
            VStack {
                Text(playerData.name)
                Text("\(playerData.points)")
            }
        }
    }
}

struct PlayerView_Previews: PreviewProvider {
    static var previews: some View {
        PlayerView(playerData: PlayerData(wind: .east, name: "Akagi", points: 25000))
    }
}
