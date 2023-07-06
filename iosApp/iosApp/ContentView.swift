import SwiftUI;
import shared;
import Alamofire;

struct ContentView: View {
    @ObservedObject var viewmodel: AlamofireDataModel;
//    @ObservedObject var viewmodel: KtorDataModel;

    var body: some View {
        List {
            ForEach(viewmodel.works, id: \.self) { work in
                Text("\(work.name) (\(work.year)), \(work.creator)");
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(viewmodel: AlamofireDataModel());
	}
}
