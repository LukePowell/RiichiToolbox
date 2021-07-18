//
//  RoundDataView.swift
//  iosApp
//
//  Created by Luke Powell on 7/17/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

class RoundDataModel: ObservableObject{
    @Published var wind: Wind = .east
    @Published var honba: Int = 0
    @Published var riichi: Int = 0
    @Published var hand: Int = 1
}

struct RoundDataView: View {
    let roundDataModel: RoundDataModel
    
    var body: some View {
        VStack {
            HStack {
                Text("\(roundDataModel.wind.kanji)")
                Text("\(roundDataModel.hand)")
            }
            .font(.title)
            HStack {
                Text("H: \(roundDataModel.honba)")
                Text("R: \(roundDataModel.riichi)")
            }
            .font(.subheadline)
        }
    }
}

struct RoundDataView_Previews: PreviewProvider {
    static var previews: some View {
        RoundDataView(roundDataModel: RoundDataModel())
    }
}
