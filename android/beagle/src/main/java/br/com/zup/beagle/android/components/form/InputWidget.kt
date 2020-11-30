/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.android.components.form

import br.com.zup.beagle.android.components.form.core.Constants
import br.com.zup.beagle.android.components.form.observer.Observable
import br.com.zup.beagle.android.components.form.observer.StateChangeable
import br.com.zup.beagle.android.components.form.observer.WidgetState
import br.com.zup.beagle.android.widget.ViewConvertable
import br.com.zup.beagle.widget.Widget
import com.squareup.moshi.JsonClass

/**
 * <p>It could be an EditText view in Android, a Radio button in HTML,
 * an UITextField in iOS or any other type of view that can receive and store input from users. </p>
 *
 */
@Deprecated(Constants.FORM_DEPRECATED_MESSAGE)
abstract class InputWidget : Widget(), ViewConvertable, StateChangeable {

    @Transient
    private val stateObservable = Observable<WidgetState>()

    abstract fun getValue(): Any

    abstract fun onErrorMessage(message: String)

    override fun getState(): Observable<WidgetState> = stateObservable

    /**
     * Notify the view the value updated
     *
     */
    fun notifyChanges() {
        stateObservable.notifyObservers(WidgetState(getValue()))
    }
}