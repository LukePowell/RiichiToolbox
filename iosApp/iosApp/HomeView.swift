//
//  HomeView.swift
//  iosApp
//
//  Created by Luke Powell on 7/17/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeView: View {
    var body: some View {
        NavigationView {
            TabView {
                ScoreCalculatorView()
                    .tabItem {
                        Image("calculate")
                        Text("Score Calc")
                    }
                Text("404: Cannot Find Hands")
                    .tabItem {
                        Image(systemName: "magnifyingglass")
                        Text("Find Hand")
                    }
                RecordGameView(game: RecordGameModel())
                    .tabItem {
                        Image(systemName: "gamecontroller.fill")
                        Text("Record Game")
                    }
            }
            .font(.headline)
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
